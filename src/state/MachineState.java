package state;

public interface MachineState {
    void AddCoin();
    void ReturnCoin();
    void SelectSoda(String soda);
    void BuySoda();
    void RetrieveSoda();
    String GetState();
}
