import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final int maxLength = 5;

    private List<int[]> groupBooks;
    private double discount;
    private double totalPrice;
    private double subTotal;

    public Calculator() {
        initGroup();
    }

    //region Get

    public double getDiscount() {
        return discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    //endregion

    public boolean addBookId(int id) {
        boolean isAssign = false;
        List<int[]> books = this.groupBooks;
        for (int[] groupBook : books) {
            if (groupBook[id-1] == 0) {
                isAssign = true;
                groupBook[id-1] = id;
                break;
            }
        }

        if (!isAssign) {
            int[] newGroup = new int[maxLength];
            newGroup[id-1] = id;
            this.groupBooks.add(newGroup);
        }

        return true;
    }

    public void removeBookId(int id) {

        List<int[]> books = this.groupBooks;
        for (int[] groupBook : books) {
            if (groupBook[id-1] > 0) {
                groupBook[id-1] = 0;
                break;
            }
        }
    }

    public boolean reset() {
        initGroup();
        return true;
    }

    public void calculatePrice() {
        List<Double> discountList = new ArrayList<>();
        List<Double> priceList = new ArrayList<>();

        for (int[] groupBook : this.groupBooks) {
            int zeroCount = countZero(groupBook);
            int totalTypeBook = maxLength - zeroCount;
            double percentDiscount = getPercentDiscount(totalTypeBook);
            double total = (totalTypeBook * 8);
            double subTotal = total - ((total * percentDiscount) / 100);
            discountList.add(subTotal);
            priceList.add(total);
        }

        this.discount = discountList.stream().mapToDouble(aDouble -> aDouble).sum();
        this.totalPrice = priceList.stream().mapToDouble(aDouble -> aDouble).sum();
        this.subTotal = this.totalPrice - discount;

    }

    //region Functions
    private void initGroup() {
        this.groupBooks = new ArrayList<>();
        this.groupBooks.add(new int[maxLength]);
    }

    private int countZero(int[] groupBook) {
        return (int) Arrays.stream(groupBook).filter(k -> k == 0).count();
    }

    private double getPercentDiscount(int type) {
        switch (type) {
            case 5:
                return 25;
            case 4:
                return 20;
            case 3:
                return 10;
            case 2:
                return 5;
        }
        return 0;
    }
    //endregion
}
