package ro.uvt.info.designpatternslab2026.commands;

public interface CommandExecutor {
    <T> T execute(Command<T> command);
}