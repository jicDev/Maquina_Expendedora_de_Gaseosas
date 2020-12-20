package state;

public interface MachineState {
    void AddCoin();
    void ReturnCoin();
    void SelectSoda(String soda);
    String GetBrandSelected();
    void BuySoda();
    void EmptyStock();
    void RetrieveSoda();
    String GetState();
}
