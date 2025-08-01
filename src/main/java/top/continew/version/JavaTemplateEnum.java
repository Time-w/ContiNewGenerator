package top.continew.version;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JavaTemplateEnum implements TemplateEnum {

	Controller400("backend/Controller.ftl", "controller", "%sController.java", "4.0.0"),
	Service400("backend/Service.ftl", "service", "%sService.java", "4.0.0"),
	ServiceImpl400("backend/ServiceImpl.ftl", "service.impl", "%sServiceImpl.java", "4.0.0"),
	Mapper400("backend/Mapper.ftl", "mapper", "%sMapper.java", "4.0.0"),
	Entity400("backend/Entity.ftl", "model.entity", "%sDO.java", "4.0.0"),
	Req400("backend/Req.ftl", "model.req", "%sReq.java", "4.0.0"),
	Query400("backend/Query.ftl", "model.query", "%sQuery.java", "4.0.0"),
	DetailResp400("backend/DetailResp.ftl", "model.resp", "%sDetailResp.java", "4.0.0"),
	Resp400("backend/Resp.ftl", "model.resp", "%sResp.java", "4.0.0"),
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
