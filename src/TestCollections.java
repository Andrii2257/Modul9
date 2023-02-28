public class TestCollections {
    public static void main(String[] args) {

        // Testing MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>(8);
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        arrayList.add(10);
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        arrayList.add(16);
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        arrayList.add(74);
        arrayList.add(65);
        arrayList.add(4);
        arrayList.add(0);
        arrayList.add(77);
        arrayList.add(14);
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        arrayList.add(-12);
        arrayList.add(-1);
        arrayList.add(36);
        arrayList.add(17);
        arrayList.add(12);
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        System.out.println("arrayList.get(6) = " + arrayList.get(6));
        System.out.println("arrayList.get(16) = " + arrayList.get(16));
        System.out.println("arrayList.get(-10) = " + arrayList.get(-10));
        System.out.println("arrayList.remove(20) = " + arrayList.remove(20));
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        arrayList.clear();
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("arrayList = " + arrayList);
        System.out.println("\n-------------------------MyLinkedList----------------------------------\n");

        // Testing MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        System.out.println("linkedList.size() = " + linkedList.size());
        System.out.println("linkedList = " + linkedList);
        linkedList.add("firstElement");
        linkedList.add("secondElement");
        linkedList.add("thirdElement");
        linkedList.add("fourthElement");
        System.out.println("linkedList.size() = " + linkedList.size());
        System.out.println("linkedList = " + linkedList);
        System.out.println("linkedList.get(1) = " + linkedList.get(1));
        System.out.println("linkedList.get(3) = " + linkedList.get(3));
        System.out.println("linkedList.remove(3) = " + linkedList.remove(3));
        System.out.println("linkedList.size() = " + linkedList.size());
        System.out.println("linkedList = " + linkedList);
        linkedList.clear();
        System.out.println("linkedList.size() = " + linkedList.size());
        System.out.println("linkedList = " + linkedList);

        MyHashMap<String,Integer> myHashMap = new MyHashMap<String,Integer>();
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.put() = " + myHashMap.put("login", 10));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.put(\"password\", 12) = " + myHashMap.put("password", 12));
        System.out.println("myHashMap.put(\"login\", 20) = " + myHashMap.put("login", 20));
        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println("myHashMap.get(\"login\") = " + myHashMap.get("login"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.remove(\"abcd\") = " + myHashMap.remove("abcd"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.remove(\"password\") = " + myHashMap.remove("password"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.get(\"password\") = " + myHashMap.get("password"));
        System.out.println("myHashMap.get(\"login\") = " + myHashMap.get("login"));

        myHashMap.clear();
        System.out.println("myHashMap.size() = " + myHashMap.size());


    }
}
