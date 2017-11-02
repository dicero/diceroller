package com.dicero.diceroller.service.play;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface PlayService {


    String createClientSeed();

    String createServerSeed();

    // NOTE: 扔色子
    boolean roller();

}
