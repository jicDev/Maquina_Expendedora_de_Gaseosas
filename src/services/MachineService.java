package services;

import dao.machine.MachineDAO;
import dao.machine.MachineDataManager;

public class MachineService {
    private MachineDAO machineDAO;

    public String AddCoin() {
        return this.machineDAO.AddCoin();
    }

    public String ReturnCoin() {
        return this.machineDAO.ReturnCoin();
    }

    public String SelectSoda(String soda) {
        return this.machineDAO.SelectSoda(soda);
    }

    public String BuySoda() {
        return this.machineDAO.BuySoda();
    }

    public String RetrieveSoda() {
        return this.machineDAO.RetrieveSoda();
    }

    public void setDao() {
        this.machineDAO = new MachineDataManager();
    }
}
