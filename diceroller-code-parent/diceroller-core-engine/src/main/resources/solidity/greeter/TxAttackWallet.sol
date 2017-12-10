pragma solidity ^0.4.12;

contract TxAttackWallet {
    address public walletAddress;
    mapping( address => uint ) _balances;
    uint _supply;

    event Transfer(address indexed from, address indexed to, uint value);
    event CoinTransfer(address sender, address receiver, uint amount);

    function TxAttackWallet( uint initial_balance, address wallet) {
        _balances[msg.sender] = initial_balance;
        _supply = initial_balance;
        walletAddress = wallet;
    }

    function getOwner() public constant returns (address) {
        return walletAddress;
    }

    function getSender() public constant returns (address) {
        return msg.sender;
    }

    function getOwnerBalance() public constant returns (uint) {
        return walletAddress.balance;
    }

    function getSenderBalance() public constant returns (uint) {
        return msg.sender.balance;
    }

    /* Very simple trade function */
    function sendCoin(address receiver, uint amount) returns(bool sufficient) {
        if (_balances[msg.sender] < amount) return false;
        _balances[msg.sender] -= amount;
        _balances[receiver] += amount;
        CoinTransfer(msg.sender, receiver, amount);
        return true;
    }

    function transferTo(address from, address to, uint value) public returns (bool ok) {
//        if( _balances[from] < value ) {
//            throw;
//        }


        to.transfer(value);
        Transfer( from, to, value );
        return true;
    }


    function show() public pure returns (string) {
        return "11";
    }
}