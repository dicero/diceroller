package com.dicero.diceroller.core.coin.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class TxAttackWallet extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405160408061046d8339810160405280805191906020018051600160a060020a03338116600090815260016020526040812086905560029590955584549116600160a060020a03199091161790925550506103fd806100706000396000f30060606040526004361061008d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663590791f281146100925780635e01eb5a146100b75780636ad5b3ea146100e6578063893d20e8146100f957806390b98a111461010c578063a5f2a15214610142578063cc80f6f31461016a578063ff18253b146101f4575b600080fd5b341561009d57600080fd5b6100a5610207565b60405190815260200160405180910390f35b34156100c257600080fd5b6100ca610217565b604051600160a060020a03909116815260200160405180910390f35b34156100f157600080fd5b6100ca61021b565b341561010457600080fd5b6100ca61022a565b341561011757600080fd5b61012e600160a060020a0360043516602435610239565b604051901515815260200160405180910390f35b341561014d57600080fd5b61012e600160a060020a03600435811690602435166044356102ec565b341561017557600080fd5b61017d610370565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156101b95780820151838201526020016101a1565b50505050905090810190601f1680156101e65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101ff57600080fd5b6100a56103b1565b600054600160a060020a03163190565b3390565b600054600160a060020a031681565b600054600160a060020a031690565b600160a060020a03331660009081526001602052604081205482901015610262575060006102e6565b600160a060020a03338181166000908152600160205260408082208054879003905592861681528290208054850190557f16cdf1707799c6655baac6e210f52b94b7cec08adcaf9ede7dfe8649da926146918590859051600160a060020a039384168152919092166020820152604080820192909252606001905180910390a15060015b92915050565b6000600160a060020a03831682156108fc0283604051600060405180830381858888f19350505050151561031f57600080fd5b82600160a060020a031684600160a060020a03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef8460405190815260200160405180910390a35060019392505050565b6103786103bf565b60408051908101604052600281527f31310000000000000000000000000000000000000000000000000000000000006020820152905090565b600160a060020a0333163190565b602060405190810160405260008152905600a165627a7a723058205ede81f6329bb2db2770eb3ae43596322e5bf0425d9efe15be1004e6fdfa996d0029";

    private TxAttackWallet(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private TxAttackWallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<CoinTransferEventResponse> getCoinTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("CoinTransfer", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<CoinTransferEventResponse> responses = new ArrayList<CoinTransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            CoinTransferEventResponse typedResponse = new CoinTransferEventResponse();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CoinTransferEventResponse> coinTransferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("CoinTransfer", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CoinTransferEventResponse>() {
            @Override
            public CoinTransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CoinTransferEventResponse typedResponse = new CoinTransferEventResponse();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> getOwnerBalance() {
        Function function = new Function("getOwnerBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getSender() {
        Function function = new Function("getSender", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> walletAddress() {
        Function function = new Function("walletAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getOwner() {
        Function function = new Function("getOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> sendCoin(String receiver, BigInteger amount) {
        Function function = new Function(
                "sendCoin", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferTo(String from, String to, BigInteger value) {
        Function function = new Function(
                "transferTo", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> show() {
        Function function = new Function("show", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getSenderBalance() {
        Function function = new Function("getSenderBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<TxAttackWallet> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initial_balance, String wallet) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initial_balance), 
                new org.web3j.abi.datatypes.Address(wallet)));
        return deployRemoteCall(TxAttackWallet.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<TxAttackWallet> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initial_balance, String wallet) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initial_balance), 
                new org.web3j.abi.datatypes.Address(wallet)));
        return deployRemoteCall(TxAttackWallet.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static TxAttackWallet load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TxAttackWallet(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TxAttackWallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TxAttackWallet(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TransferEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }

    public static class CoinTransferEventResponse {
        public String sender;

        public String receiver;

        public BigInteger amount;
    }
}
