package state;

public class WithoutStockState implements MachineState {
    @Override
    public void AddCoin() {

    }

    @Override
    public void ReturnCoin() {

    }

    @Override
    public void SelectSoda(String soda) {

    }

    @Override
    public void BuySoda() {

    }

    @Override
    public void RetrieveSoda() {

    }

    @Override
    public String GetState() {
        return "SIN_STOCK";
    }
}
