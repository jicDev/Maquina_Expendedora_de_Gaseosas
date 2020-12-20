package state;

public class WithStockState implements MachineState {
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
        return "CON_STOCK";
    }
}
