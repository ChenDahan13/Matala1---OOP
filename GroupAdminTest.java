import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
  * Junit test class for GroupAdmin class
  * The main purpose is to see if the methods
  * in GroupAdmin class work
  * @author Chen Dahan
  * 17.12.2022
  */


class GroupAdminTest {

    GroupAdmin a = new GroupAdmin();

    ConcreteMember Chen = new ConcreteMember(a, "Chen");
    ConcreteMember Barak = new ConcreteMember(a, "Barak");
    ConcreteMember Nikita = new ConcreteMember(a, "Nikita");
    ConcreteMember Gilad = new ConcreteMember(a, "Gilad");


    @Test
    void appendTest() {
        a.append("Test");
        assertEquals("Test", a.getUsb().toString());
        a.append(" is happening");
        assertEquals("Test is happening", a.getUsb().toString());
        a.append(" now");
        assertEquals("Test is happening now", a.getUsb().toString());
        System.out.println("Append test completed successfully");
    }

    @Test
    void insertTest() {
        a.insert(0,"Chen is the king");
        assertEquals("Chen is the king", a.getUsb().toString());
        a.insert(4, " Dahan");
        assertEquals("Chen Dahan is the king", a.getUsb().toString());
        System.out.println("Insert test completed successfully");
    }

    @Test
    void deleteTest() {
        a.append("Chen was here");
        a.delete(0, 5);
        assertNotSame("Chen was here", a.getUsb().toString());
        assertEquals("was here", a.getUsb().toString());
        System.out.println("Delete test completed successfully");
    }
    @Test
    void undoTest() {
        a.append("Chen was here");
        a.append(" now");
        a.undo();
        assertEquals("Chen was here", a.getUsb().toString());
        System.out.println("Undo test completed successfully");
    }
    @Test
    void notifyTest() {
        a.append("Test");
        a.register(Chen);
        a.register(Barak);
        a.register(Nikita);
        a.register(Gilad);
        a.notifyMembers();
        a.append(" is happening");
        a.notifyMembers();
        assertEquals(Chen.getMemberState().toString(), "Test is happening");
        assertEquals(Nikita.getMemberState().toString(), "Test is happening");
        assertEquals(Barak.getMemberState().toString(), "Test is happening");
        assertEquals(Gilad.getMemberState().toString(), "Test is happening");
        a.delete(1,4);
        a.notifyMembers();
        assertEquals(Chen.getMemberState().toString(), "T is happening");
        assertEquals(Nikita.getMemberState().toString(), "T is happening");
        assertEquals(Barak.getMemberState().toString(), "T is happening");
        assertEquals(Gilad.getMemberState().toString(), "T is happening");
        a.undo();
        a.notifyMembers();
        assertEquals(Chen.getMemberState().toString(), "Test is happening");
        assertEquals(Nikita.getMemberState().toString(), "Test is happening");
        assertEquals(Barak.getMemberState().toString(), "Test is happening");
        assertEquals(Gilad.getMemberState().toString(), "Test is happening");
        System.out.println("Notify test completed successfully");
    }
}