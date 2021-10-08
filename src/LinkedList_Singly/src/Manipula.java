import modelo.Pessoa;

public class Manipula {
    public Pessoa head=null, tail=null;
    public int size_of_list=0;

    public void addLast(Pessoa p){
        if(head == null){
            head = p;
            tail = p;
            p.next = null;
        }else{
            tail.next = p;
            tail = p;
            p.next = null;
        }
        size_of_list++;
    }

    public void addFirst(Pessoa p){
        if(head == null){
            head = p;
            tail = p;
            p.next = null;
        }else{
            p.next = head;
            head = p;
        }
        size_of_list++;
    }

    public void printList(){
        Pessoa p = head;
        if(p == null){
            System.out.println("List is empty");
        }else{
            while (p != null){
                System.out.println(p.toString());
                p = p.next;
            }
        }
    }

    public Pessoa getFirst(){
        return head;
    }

    public Pessoa getLast(){
        return tail;
    }

    public void removeFirst(){
        Pessoa p = getFirst();
        if (p == null)
            System.out.println("List is empty");
        else {
            head = p.next;
            size_of_list--;
        }
    }

    public boolean isEmpty(){
        return size_of_list == 0;
    }

    public boolean contains(String name){
        boolean exists = false;
        Pessoa aux = head;
        while (aux != null){
            if (aux.nome.equalsIgnoreCase(name))
                exists = true;
            aux = aux.next;
        }
        return exists;
    }

    public int indexOf(String name){
        int index = -1;
        Pessoa aux = head;
        if (aux == null){
            System.out.println("List is empty");
        }else{
            if(aux.nome.equalsIgnoreCase(name)) {
                index = 0;
            }else {
                aux = aux.next;
                while (aux != null) {
                    if (aux.nome.equalsIgnoreCase(name))
                        index++;
                    aux = aux.next;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Pessoa p = new Pessoa("Yara",29);
        Pessoa p1 = new Pessoa("Beto",23);
        Pessoa p2 = new Pessoa("Dalton",17);

        Manipula m = new Manipula();
        m.addFirst(p);
        m.addFirst(p1);
        m.addFirst(p2);

        m.printList();
        System.out.println("index: "+m.indexOf("yara"));

        m.removeFirst();
        System.out.println("==============");
        m.printList();

        System.out.println("index: "+m.indexOf("dalton"));
    }
}
