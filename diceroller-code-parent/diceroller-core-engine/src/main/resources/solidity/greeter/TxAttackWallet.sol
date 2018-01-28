pragma solidity ^0.4.16;

contract SafeMath {
    function safeMul(uint a, uint b) internal returns (uint) {
        uint c = a * b;
        assert(a == 0 || c / a == b);
        return c;
    }

    function safeSub(uint a, uint b) internal returns (uint) {
        assert(b <= a);
        return a - b;
    }

    function safeAdd(uint a, uint b) internal returns (uint) {
        uint c = a + b;
        assert(c>=a && c>=b);
        return c;
    }

    function assert(bool assertion) internal {
        if (!assertion) throw;
    }
}

contract TxAttackWallet is SafeMath {

    mapping (address => mapping (address => uint)) public tokens;
    mapping(address => uint) balances;
    address public admin;

    function TxAttackWallet() {
        admin = msg.sender;
//        tokens[0][msg.sender] = 10;
    }


    event Deposit(address token, address user, uint amount, uint balance);
    event Withdraw(address token, address user, uint amount, uint balance);
    event Trade(address token, address user, uint amount, uint balance);

    // Test
    function sender() public constant returns (address) {
        return msg.sender;
    }

    function deposit() payable {
        tokens[0][msg.sender] = safeAdd(tokens[0][msg.sender], msg.value);
        Deposit(0, msg.sender, msg.value, tokens[0][msg.sender]);
    }

    function withdraw(uint amount) {
        if (tokens[0][msg.sender] < amount) throw;
        tokens[0][msg.sender] = safeSub(tokens[0][msg.sender], amount);
        if (!msg.sender.call.value(amount)()) throw;
        Withdraw(0, msg.sender, amount, tokens[0][msg.sender]);
    }

    function playTrade(uint payout, bool result) payable {
        tokens[0][msg.sender] = safeAdd(tokens[0][msg.sender], msg.value);
        Deposit(0, msg.sender, msg.value, tokens[0][msg.sender]);

        if(result) {
            if (!msg.sender.call.value(payout)()) throw;
            tokens[0][admin] = safeSub(tokens[0][admin], payout);
        } else {
            tokens[0][msg.sender] = safeSub(tokens[0][msg.sender], msg.value);
            tokens[0][admin] = safeAdd(tokens[0][admin], msg.value);
        }
    }

    function balanceOf(address token, address user) public constant returns (uint) {
        return tokens[0][token];
    }


}
