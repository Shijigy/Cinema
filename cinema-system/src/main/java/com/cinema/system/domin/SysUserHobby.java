package com.cinema.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 个人爱好
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUserHobby implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long userHobbyId;

    @NotBlank(message = "爱好名称不能为空")
    private String userHobbyName;

}