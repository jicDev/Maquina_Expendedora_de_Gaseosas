package state;

import entidades.Machine;

public class ReadyState implements MachineState {
    private final Machine machine;

    public ReadyState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void AddCoin() {
        this.machine.SetState(new WithCoinState(this.machine));
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
        return "MAQUINA_LISTA";
    }
}
