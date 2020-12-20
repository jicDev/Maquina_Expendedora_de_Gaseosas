package state;

import entidades.Machine;

public class WithoutStockState implements MachineState {
    private Machine machine;

    public WithoutStockState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void AddCoin() {

    }

    @Override
    public void ReturnCoin() {
        this.machine.SetState(new ReadyState(this.machine));
    }

    @Override
    public void SelectSoda(String soda) {

    }

    @Override
    public String GetBrandSelected() {
        return null;
    }

    @Override
    public void BuySoda() {

    }

    @Override
    public void EmptyStock() {

    }

    @Override
    public void RetrieveSoda() {

    }

    @Override
    public String GetState() {
        return "SIN_STOCK";
    }
}
