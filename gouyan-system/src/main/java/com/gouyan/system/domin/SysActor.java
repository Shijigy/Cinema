package com.gouyan.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author lxd
 * @create 2020-11-23 14:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysActor implements Serializable {

    private static final Long serialVersionUID = 1L;

    //演员id
    private Long actorId;

    //演员名
    @NotBlank(message = "演员名不能为空")
    private String actorName;

    //演员图片
//    @NotBlank(message = "演员图片不能为空")
    private String actorPhoto;

    //演员身高
    @Range(min = 100, max = 300, message = "身高需要在1m到3m之间")
    private Double actorHeight;

    @Min(value = 0, message = "年龄不得低于0")
    @Max(value = 100, message = "年龄不得高于100")
    private Integer actorAge;

    @NotNull(message = "性别不能为空")
    private Boolean actorGender;

//    @NotBlank(message = "毕业院校不得为空")
    private String actorSchool;

}
