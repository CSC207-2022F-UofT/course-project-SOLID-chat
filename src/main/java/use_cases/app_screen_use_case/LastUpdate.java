package use_cases.app_screen_use_case;

import entities.chat.Chat;

import java.time.LocalDateTime;

public interface LastUpdate {
    LocalDateTime getLastUpdatedTime(Chat chat);
}
