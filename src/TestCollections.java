public class TestCollections {
    public static void main(String[] args) {
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

    }
}
