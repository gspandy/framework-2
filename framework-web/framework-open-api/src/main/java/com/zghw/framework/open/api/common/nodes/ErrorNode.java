package com.zghw.framework.open.api.common.nodes;

import org.springframework.util.StringUtils;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.object.dto.Result;
import com.zghw.framework.object.dto.ResultConstant;

/**
 * 错误节点处理结果
 * 
 * @author zghw
 *
 */
public class ErrorNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		Result result = valueStack.getValue(RESULT, Result.class);
		if (result != null) {
			return null;
		}
		String code = valueStack.getString(CODE);
		String state = valueStack.getString(STATE);
		String msg = valueStack.getString(MSG);
		Object data = valueStack.getValue(DATA);
		code = StringUtils.hasText(code) ? code : ResultConstant.ERROR_CODE;
		state = StringUtils.hasText(state) ? state : ResultConstant.ERROR_STATE;
		msg = StringUtils.hasText(msg) ? msg : ResultConstant.ERROR_MSG;
		result = new Result(code, state, msg, data);
		valueStack.setValue(RESULT, result);
		return null;
	}

}
