package com.chuhui.chat.services;

import com.chuhui.chat.interfaces.IndexInterface;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

import static com.chuhui.chat.framework.constant.Contants.customTimeFormat;
import static com.chuhui.chat.framework.constant.Contants.formatCurrentTime;

/**
 * services
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description:TODO
 */
@Service
public class IndexService implements IndexInterface {


    @Override
    public String getString() {

        String currentTime = formatCurrentTime(customTimeFormat);

        String uuidStr = UUID.randomUUID().toString();

        String result = MessageFormat.format("get String method, time:{0},uuid:{1}", currentTime, uuidStr);


        return result;
    }

}
