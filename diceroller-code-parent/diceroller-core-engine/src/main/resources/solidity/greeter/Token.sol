pragma solidity ^0.4.2;


contract Token {
    // The keyword "public" makes those variables
    // readable from outside.
    address public recipient;
    mapping (address => uint) public _balances;

    // Events allow light clients to react on
    // changes efficiently.
    event Sent(address from, address to, uint amount );


    function send(address receiver, uint amount) {
        if (_balances[msg.sender] < amount) return;
        _balances[msg.sender] -= amount;
        _balances[receiver] += amount;
        return Sent(msg.sender, receiver, amount);
    }
}
