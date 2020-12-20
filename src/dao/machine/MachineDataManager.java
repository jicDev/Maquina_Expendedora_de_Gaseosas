package dao.machine;

import entidades.Machine;

public class MachineDataManager implements MachineDAO{
    private Machine machine;

    public MachineDataManager() {
        this.machine = new Machine();
    }

    @Override
    public String AddCoin() {
        return this.machine.AddCoin();
    }

    @Override
    public String ReturnCoin() {
        return this.machine.ReturnCoin();
    }

    @Override
    public String SelectSoda(String soda) {
        return this.machine.SelectSoda(soda);
    }

    @Override
    public String BuySoda() {
        return this.machine.BuySoda();
    }

    @Override
    public String RetrieveSoda() {
        return this.machine.RetrieveSoda();
    }
}
