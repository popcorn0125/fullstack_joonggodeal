package com.Joonggodeal.joonggodeal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ResultDto<T> {
    private HttpStatus httpStatus;
    private String resultMsg;
    private T resultData;

    public ResultDto(HttpStatus httpStatus, String resultMsg) {
        this.httpStatus = httpStatus;
        this.resultMsg = resultMsg;
        this.resultData =  null;
    }

    public static<T> ResultDto<T> res(final HttpStatus httpStatusCode, final String resultMsg) {
        return res(httpStatusCode,resultMsg, null);
    }

    public static<T> ResultDto<T> res(final HttpStatus httpStatusCode, final String resultMsg, final T t) {
        return ResultDto.<T>builder()
                .resultData(t)
                .httpStatus(httpStatusCode)
                .resultMsg(resultMsg)
                .build();
    }
}
