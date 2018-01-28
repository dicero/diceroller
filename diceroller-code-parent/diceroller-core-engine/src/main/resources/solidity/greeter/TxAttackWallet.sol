pragma solidity 0.4.16;

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

    mapping (address => uint) private playCoins;
    mapping(address => uint) private balances;
    address private admin;

    function TxAttackWallet() {
        admin = msg.sender;
    }


    event LogDeposit(address token, address user, uint amount, uint balance);
    event LogWithdraw(address token, address user, uint amount, uint balance);
    event LogTrade(address token, address user, uint amount, uint balance);

    function deposit() payable internal {
        playCoins[msg.sender] = safeAdd(playCoins[msg.sender], msg.value);
        LogDeposit(0, msg.sender, msg.value, playCoins[msg.sender]);
    }

    function withdraw(uint amount) internal {
        if (playCoins[msg.sender] < amount) throw;
        playCoins[msg.sender] = safeSub(playCoins[msg.sender], amount);
        if (!msg.sender.call.value(amount)()) throw;
        LogWithdraw(0, msg.sender, amount, playCoins[msg.sender]);
    }

    function playTrade(uint payout, bool result) payable internal {
        playCoins[msg.sender] = safeAdd(playCoins[msg.sender], msg.value);
        LogDeposit(0, msg.sender, msg.value, playCoins[msg.sender]);

        if(result) {
            if (!msg.sender.call.value(payout)()) throw;
            playCoins[admin] = safeSub(playCoins[admin], payout);
        } else {
            playCoins[msg.sender] = safeSub(playCoins[msg.sender], msg.value);
            playCoins[admin] = safeAdd(playCoins[admin], msg.value);
        }
    }

    function balanceOf(address token, address user) public constant returns (uint) {
        return playCoins[token];
    }


}
