package cr;

class Credentials {
    private final int customerNumber;
    private final int pin;

    public Credentials(int customerNumber, int pin) {
        if (String.valueOf(pin).length() != 6) {
            throw new IllegalArgumentException("PIN must be 6 digits");
        }
        this.customerNumber = customerNumber;
        this.pin = pin;
    }

    public int getCustomerNumber() { return customerNumber; }
    public int getPin() { return pin; }
}
