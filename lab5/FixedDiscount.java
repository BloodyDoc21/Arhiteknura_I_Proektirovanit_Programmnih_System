public class FixedDiscount implements Discount {
    private double amount;

    public FixedDiscount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма скидки должна быть больше нуля");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double apply(double sum) {
        if (amount >= sum) {
            return 0;
        }
        return sum - amount;
    }

    @Override
    public String getDescription() {
        return "скидка " + amount + " руб.";
    }
}
