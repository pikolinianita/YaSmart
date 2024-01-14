package pl.lcc.yasmart.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class RewardType {

    private UUID id;
    private String name;
    private String iconName;
    private String  colorHex;

    public RewardType(String name, String iconName, String colorHex) {
        this.name = name;
        this.iconName = iconName;
        this.colorHex = colorHex;
        id = UUID.randomUUID();
    }
}
