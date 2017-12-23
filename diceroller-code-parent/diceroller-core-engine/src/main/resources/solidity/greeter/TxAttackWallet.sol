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
    struct Wallet {
        address delegate;
        uint supply;
    }


    mapping (address => mapping (address => uint)) public tokens;
    mapping(address => uint) balances;
    uint public totalSupply;
    address public admin;

    Wallet[] public wallets;


    function TxAttackWallet() {
        admin = msg.sender;
        totalSupply = 10;
    }


    event Deposit(address token, address user, uint amount, uint balance);
    event Withdraw(address token, address user, uint amount, uint balance);
    event Trade(address token, address user, uint amount, uint balance);


    function totalSupply() public constant returns (uint supply) {
        return totalSupply;
    }

    // Test
    function sender() public constant returns (address) {
        return msg.sender;
    }

//    function deposit() public payable {
//        tokens[0][msg.sender] = safeAdd(tokens[0][msg.sender], msg.value);
//        Deposit(0, msg.sender, msg.value, tokens[0][msg.sender]);
//    }


    function build(address delegate) public returns (uint) {
        wallets.push(Wallet({
            delegate: delegate,
            supply: 0
        }));

        return wallets[0].supply;
    }

    function voterSupply(address delegate) public constant returns (uint) {
        return wallets[0].supply;
    }

//    function depositToken(address token, uint amount)  constant public returns (bool success)  {
//        if (token==0) throw;
//        if (transferFrom(msg.sender, this, amount)) throw;
//        tokens[token][msg.sender] = safeAdd(tokens[token][msg.sender], amount);
//        wallets[0].supply = wallets[0].supply + amount;
//        Deposit(token, msg.sender, amount, tokens[token][msg.sender]);
//        return true;
//    }
//
//    function tradeToken(address token, uint amount) constant returns (bool success) {
//        if (token==0) throw;
//        if (tokens[token][msg.sender] < amount) throw;
//        tokens[token][msg.sender] = safeSub(tokens[token][msg.sender], amount);
////        Trade(token, msg.sender, amount, tokens[token][msg.sender]);
//        return true;
//    }
//
//    function withdrawToken(address token, uint amount) public {
//        if (token==0) throw;
//        if (tokens[token][msg.sender] < amount) throw;
//        tokens[token][msg.sender] = safeSub(tokens[token][msg.sender], amount);
////        if (transferFrom(this, msg.sender, amount)) throw;
//        Withdraw(token, msg.sender, amount, tokens[token][msg.sender]);
//    }

    function balanceOf(address token, address user) public constant returns (uint) {
        return tokens[token][user];
    }

//    event Transfer(address indexed _from, address indexed _to, uint _value);
//
//    function transferFrom(address _from, address _to, uint _value) returns (bool success) {
//        if (balances[_from] >= _value  && balances[_to] + _value > balances[_to]) {
//            balances[_to] += _value;
//            balances[_from] -= _value;
//            Transfer(_from, _to, _value);
//            return true;
//        } else { return false; }
//    }

}
