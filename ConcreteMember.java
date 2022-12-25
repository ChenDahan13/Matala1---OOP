import java.util.Stack;
/**
  * ConcreteMember is a class that using with UndoableStringBuilder
  * This class is a member in the GroupAdmin class
  * Any object from this class gets updates when the
  * UndoableStringBuilder is changed by the GroupAdmin
  * @author Chen Dahan
  * 17.12.2022
  */

public class ConcreteMember implements Member {
    private String name;
    private UndoableStringBuilder memberState;
    private GroupAdmin admin;

    public UndoableStringBuilder getMemberState() {
        return memberState;
    }

    public ConcreteMember(GroupAdmin admin, String name) {
        this.name = name;
        this.admin = admin;
    }
    public void update(UndoableStringBuilder usb) {
        memberState = new UndoableStringBuilder(usb);
        System.out.println("Member "+name+" new state is updated: "+memberState.toString());
    }

}
