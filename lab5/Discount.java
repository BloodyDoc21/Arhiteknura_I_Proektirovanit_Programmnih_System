public interface Discount {
    double apply(double sum);

    String getDescription();
}
