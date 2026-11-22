package ro.uvt.info.designpatternslab2026.commands;

import org.springframework.stereotype.Component;

@Component
public class SyncCommandExecutor implements CommandExecutor {

    @Override
    public <T> T execute(Command<T> command) {
        return command.execute();
    }
}