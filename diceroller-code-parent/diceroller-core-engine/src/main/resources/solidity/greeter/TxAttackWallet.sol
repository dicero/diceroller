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
    uint public totalSupply;
    address public admin;

    function TxAttackWallet() {
        admin = msg.sender;
        totalSupply = 10;
    }


    event Deposit(address token, address user, uint amount, uint balance);
    event Withdraw(address token, address user, uint amount, uint balance);
    event Trade(address token, address user, uint amount, uint balance);


    function totalSupply() public constant returns (uint) {
        return totalSupply;
    }

    // Test
    function sender() public constant returns (address) {
        return msg.sender;
    }

//
    //    function trade(address token, uint amount, uint payout, bool result) public {
    //        if (transferFrom(msg.sender, this, amount)) throw;
    //
    //        if(result) {
    //            if (transferFrom(this, msg.sender, payout)) throw;
    //        }
    //
    //    }
    //
    //    function tradeToContract(address contractAddress, uint amount) public {
    //        if (transferFrom(msg.sender, contractAddress, amount)) throw;
    //    }

    function depositToken(address token, uint amount)  public  {
        if (token==0) throw;
        if (transferFrom(msg.sender, this, amount)) throw;
        tokens[token][msg.sender] = safeAdd(tokens[token][msg.sender], amount);
        totalSupply = safeAdd(totalSupply, amount);
        Deposit(token, msg.sender, amount, tokens[token][msg.sender]);
    }

    function withdrawToken(address token, uint amount) public {
        if (token==0) throw;
        if (tokens[token][msg.sender] < amount) throw;
        tokens[token][msg.sender] = safeSub(tokens[token][msg.sender], amount);
        totalSupply = safeSub(totalSupply, amount);
        if (transferFrom(this, msg.sender, amount)) throw;
        Withdraw(token, msg.sender, amount, tokens[token][msg.sender]);
    }

//    function tradeToken(address token, uint amount) constant returns (bool success) {
//        if (token==0) throw;
//        if (tokens[token][msg.sender] < amount) throw;
//        if (transferFrom(this, msg.sender, amount)) throw;
//        tokens[token][msg.sender] = safeSub(tokens[token][msg.sender], amount);
//        Trade(token, msg.sender, amount, tokens[token][msg.sender]);
//        return true;
//    }


//    function balanceOf(address token, address user) public constant returns (uint) {
//        return balances[token];
//    }

    function balanceOf(address token, address user) public constant returns (uint) {
        return tokens[token][user];
    }

    function issue(address account, uint amount) {
        if (msg.sender != admin) throw;
        balances[account] += amount;
    }

    event Transfer(address indexed _from, address indexed _to, uint _value);

    function getBalance(address account) constant returns (uint) {
        return balances[account];
    }

    function transferFrom(address _from, address _to, uint _value) payable returns (bool success) {
        if (balances[_from] >= _value  && balances[_to] + _value > balances[_to]) {
            balances[_to] += _value;
            balances[_from] -= _value;
            Transfer(_from, _to, _value);
            return true;
        } else { return false; }
    }

}
