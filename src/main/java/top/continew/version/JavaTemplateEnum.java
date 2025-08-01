package top.continew.version;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JavaTemplateEnum implements TemplateEnum {

	Controller("backend/Controller.ftl", "controller", "%sController.java", "4.0.0"),
	Service("backend/Service.ftl", "service", "%sService.java", "4.0.0"),
	ServiceImpl("backend/ServiceImpl.ftl", "service.impl", "%sServiceImpl.java", "4.0.0"),
	Mapper("backend/Mapper.ftl", "mapper", "%sMapper.java", "4.0.0"),
	Entity("backend/Entity.ftl", "model.entity", "%sDO.java", "4.0.0"),
	Req("backend/Req.ftl", "model.req", "%sReq.java", "4.0.0"),
	Query("backend/Query.ftl", "model.query", "%sQuery.java", "4.0.0"),
	DetailResp("backend/DetailResp.ftl", "model.resp", "%sDetailResp.java", "4.0.0"),
	Resp("backend/Resp.ftl", "model.resp", "%sResp.java", "4.0.0"),
	//
	;

	private final String templatePath;
	private final String packageName;
	private final String fileName;
	private final String version;

	@Override
	public boolean firstToLowerCase() {
		return false;
	}
}
