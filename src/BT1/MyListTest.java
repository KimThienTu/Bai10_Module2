package BT1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        //Thêm phần tử vào danh sách.
        list.add("A");
        list.add("B");
        list.add("C");

        // In danh sách.
        System.out.println("Danh sách sau khi thêm các phần tử: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Kiểm tra phần tử B có tồn tại trong danh sách không.
        boolean containsB = list.contains("B");
        System.out.println("Có chứa phần tử B là: " + containsB);

        //Lấy chỉ số của phần tử C trong danh sách.
        int indexC = list.indexOf("C");
        System.out.println("Chỉ số của phần tử C là: " + indexC);

        //Xóa phần tử B khỏi danh sách.
        String removeElement = list.remove(1);
        System.out.println("Phàn tử đã bị xóa: " + removeElement);

        //In danh sách sau khi xóa.
        System.out.println("Danh sách sau khi xóa phần tử là: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Xóa toàn bộ phần tử trong danh sách.
        list.clear();
        System.out.println("Danh sách sau khi xóa tất cả phần tử: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
