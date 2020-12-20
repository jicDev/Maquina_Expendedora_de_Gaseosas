package state;

import entidades.Machine;

public class WithCoinState implements MachineState {
    private final Machine machine;

    public WithCoinState(Machine machine) {
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
        this.machine.SetState(new ExpendingState(this.machine, soda));
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
        return "CON_FICHA";
    }
}
