package com.epam.menu.service;

import com.epam.menu.service.impl.DomCommand;
import com.epam.menu.service.impl.SaxCommand;
import com.epam.menu.service.impl.StaxCommand;
import com.epam.menu.web.RequestedParserType;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final CommandHelper instance=new CommandHelper();
    private Map<String,Command> commands=new HashMap<>();

    public CommandHelper() {
        commands.put(RequestedParserType.REQUEST_SAX, new SaxCommand());
        commands.put(RequestedParserType.REQUEST_STAX,new StaxCommand());
        commands.put(RequestedParserType.REQUEST_DOM, new DomCommand());
    }

    public static CommandHelper getInstance() {
        return instance;
    }

    public Command getCommand(String commandName){
        Command command;
        if (commandName.equals(RequestedParserType.REQUEST_SAX)){
            return commands.get(commandName);
        }
        if (commandName.equals(RequestedParserType.REQUEST_STAX)){
            return commands.get(commandName);
        }
        if (commandName.equals(RequestedParserType.REQUEST_DOM)){
            return commands.get(commandName);
        }
        else return null;
    }
}
