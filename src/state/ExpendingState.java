package state;

import entidades.Machine;

public class ExpendingState implements MachineState {
    private final Machine machine;
    private String soda;

    public ExpendingState(Machine machine, String soda) {
        this.machine = machine;
        this.soda = soda;
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
        this.soda = soda;
    }

    @Override
    public String GetBrandSelected() {
        return this.soda;
    }

    @Override
    public void BuySoda() {
        this.machine.SetState(new ExpendedState(this.machine));
    }

    @Override
    public void EmptyStock() {
        this.machine.SetState(new WithoutStockState(this.machine));
    }

    @Override
    public void RetrieveSoda() {

    }

    @Override
    public String GetState() {
        return "EXPENDIENDO";
    }
}
