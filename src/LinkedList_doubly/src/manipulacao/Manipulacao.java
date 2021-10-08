package manipulacao;

import modelo.Pessoa;

public class Manipulacao {
    Pessoa head = null, tail = null;

    public void addBiginning(Pessoa p){
        if (head == null){
            head = p;
            tail = p;
            p.next = null;
            p.prev = null;
        }else{
             p.next = head;
             head.prev = p;
             head = p;
             p.prev = null;
        }
    }

    public void addLast(Pessoa p){
        if (head == null){
            head = p;
            tail = p;
            p.next = null;
            p.prev = null;
        }else{
            tail.next = p;
            p.prev = tail;
            p.next = null;
            tail = p;
        }
    }

    public void addAt(int pos, Pessoa p){
        int counter = 0;

        if (head == null){
            System.out.println("List is empty");
        }else{
            Pessoa aux = head;

                if (pos == 0){
                    p.next = aux;
                    aux.prev = p;
                    p.prev = null;
                    head = p;
                    System.out.println("entrou no pos=0");
                }else {
                     while (aux != null){
                        System.out.println(counter);
                        if (pos == counter && aux.next != null){
                            Pessoa temp = aux.prev;
                            temp.next = p;
                            p.prev = temp;
                            p.next = aux;
                            aux.prev = p;
                        }else{
                            if (pos == counter && aux.next == null){
                                Pessoa temp = aux.prev;
                                temp.next = p;
                                p.prev = temp;
                                p.next = aux;
                                aux.prev = p;
                                aux.next = null;
                            }
                        }
                    aux = aux.next;
                    counter++;
                }
            }
        }
    }

    public void deleteBiginning(){
        Pessoa aux = head;

        if (head == null){
            System.out.println("list is empty");
        }else{
            if (aux.next == null){
                head = null;
                tail = null;
            }else{
                head = aux.next;
                head.prev = null;
            }
        }
    }

    public void deleteLast(){
        if (head == null){
            System.out.println("List is empty");
        }else{
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteSpecified(String nome) {
        Pessoa aux = head;

        if (head == null) {
            System.out.println("List is empty");
        } else {
                if (head.getNome().equalsIgnoreCase(nome)) {
                    if (head.next == null){
                        head = null;
                        tail = null;
                    }else{
                        head = head.next;
                        head.prev = null;
                    }
                }else{
                    if (tail.getNome().equalsIgnoreCase(nome)){
                        if (tail.prev == null){
                            tail = null;
                            head = null;
                        }else{
                            tail = tail.prev;
                            tail.next = null;
                        }
                    }else{
                        aux = aux.next;
                        Pessoa aux1 = aux.next;
                        while (aux1 != null){
                            if (aux.getNome().equalsIgnoreCase(nome)){
                                aux1.prev = aux.prev;
                                aux.prev.next = aux1;
                            }
                            aux = aux.next;
                            aux1 = aux1.next;
                        }
                    }
                }

        }
    }


    public void printList(){
        Pessoa aux = head;
        if(aux == null){
            System.out.println("list is empty");
        }else {
            while (aux != null) {
                System.out.println(aux);
                aux = aux.next;
            }
        }
    }

    public static void main(String[] args) {
        Manipulacao man = new Manipulacao();

        Pessoa p = new Pessoa("Beto",23);
        Pessoa p1 = new Pessoa("Dalton",17);
        Pessoa p2 = new Pessoa("Yara", 29);
        Pessoa p3 = new Pessoa("Yalsen",5);

        man.addBiginning(p);
        man.addLast(p1);
        man.addLast(p3);
        man.printList();

        man.addAt(2,p2);
        man.printList();
        System.out.println("---------");
//        man.deleteSpecified("Yara");
//        man.printList();

        man.deleteBiginning();
        man.printList();
        System.out.println("====");
        man.deleteLast();
        man.printList();
    }

}
