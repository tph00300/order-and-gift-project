package msa.order.common.exception

import msa.order.common.response.ErrorCode

class NotFoundUserException : BaseException {
    constructor() : super(ErrorCode.NOT_FOUND_USER) {}
    constructor(errorCode: ErrorCode) : super(errorCode) {}
    constructor(errorMsg: String) : super(errorMsg, ErrorCode.NOT_FOUND_USER) {}
    constructor(message: String, errorCode: ErrorCode) : super(message, errorCode) {}
}
