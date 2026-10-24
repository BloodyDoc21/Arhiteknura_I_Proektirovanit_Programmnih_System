public class PercentDiscount implements Discount {
    private int percent;

    public PercentDiscount(int percent) {
        if (percent <= 0 || percent > 50) {
            throw new IllegalArgumentException(
                    "Скидка должна быть от 1 до 50%");
        }
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public double apply(double sum) {
        return sum - sum * percent / 100;
    }

    @Override
    public String getDescription() {
        return "скидка " + percent + "%";
    }
}
