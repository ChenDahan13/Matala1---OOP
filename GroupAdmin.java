import java.util.ArrayList;

/**
  * GroupAdmin class is an Observer class
  * which using with UndoableStringBuilder.
  * When change in the string is happening all the members
  * in the GroupAdmin will update with the change.
  * @author Chen Dahan
  * 17.12.2022
  */
public class GroupAdmin implements Sender {
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    public UndoableStringBuilder getUsb() {
        return usb;
    }
    public void register(Member obj){
        members.add(obj);
    }
    public void unregister(Member obj) {
        members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset,obj);
    }
    @Override
    public void append(String str) {
        usb.append(str);
    }
    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
    }
    @Override
    public void undo() {
        usb.undo();
    }

    public void notifyMembers() {
        for(Member m: members) {
            m.update(usb);
        }
        System.out.println();
    }
}
