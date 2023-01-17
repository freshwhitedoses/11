public class Main {
    public static void main(String[] args) {
        int[] array= new int[]{1,2,4,5,6};
        LinkedIntList list= LinkedIntList.fromList(array);
        list.firstLast();
        list.out();
    }
}


class ListIntNode{
    public int data;
    public ListIntNode next;
    ListIntNode(int data){
        this.data=data;
        next=null;
    }
    void add(int val){
        if (this.next == null) {
            this.next = new ListIntNode(val);
        } else {
            this.next.add(val);
        }
    }


}

class LinkedIntList{
    ListIntNode first = null;
    static LinkedIntList fromList(int[] array){
        LinkedIntList list = new LinkedIntList();
        for(int i:array){
            list.add(i);
        }
        return list;
    }
    void add(int val){
        if(first!=null) first.add(val);
        else first = new ListIntNode(val);
    }
    void firstLast(){
        ListIntNode current = first;
        ListIntNode current2 = first;
        ListIntNode sec = first.next;
        first=sec;
        while (current2.next!=null){
            current2=current2.next;
        }
        current2.next=current;
        current.next=null;
    }
    void out() {
        var el = first;
        String result = "";
        while (el != null) {
            result += (el.data)+" ";
            el = el.next;
        }
        System.out.println(result);
    }
}
