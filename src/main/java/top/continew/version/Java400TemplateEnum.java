package top.continew.version;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Java400TemplateEnum implements TemplateEnum {

	Controller("backend/Controller.ftl", "controller", "%sController.java"),
	Service("backend/Service.ftl", "service", "%sService.java"),
	ServiceImpl("backend/ServiceImpl.ftl", "service.impl", "%sServiceImpl.java"),
	Mapper("backend/Mapper.ftl", "mapper", "%sMapper.java"),
	Entity("backend/Entity.ftl", "model.entity", "%sDO.java"),
	Req("backend/Req.ftl", "model.req", "%sReq.java"),
	Query("backend/Query.ftl", "model.query", "%sQuery.java"),
	DetailResp("backend/DetailResp.ftl", "model.resp", "%sDetailResp.java"),
	Resp("backend/Resp.ftl", "model.resp", "%sResp.java"),
	//
	;

	private final String templatePath;
	private final String packageName;
	private final String fileName;

	@Override
	public boolean firstToLowerCase() {
		return false;
	}
}
