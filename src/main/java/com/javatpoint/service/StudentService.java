package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.BaseEntity;
import com.javatpoint.model.GuideLinesEntity;
import com.javatpoint.model.RegionalEntity;
import com.javatpoint.model.SubRegionEntity;
import com.javatpoint.repository.StudentRepository;
import com.javatpoint.repository.SubRegionRepository;




//defining the business logic
@Service
public class StudentService 
{
@Autowired
StudentRepository studentRepository;
@Autowired
SubRegionRepository subRegionRepository;
//getting all student records
public List<GuideLinesEntity> getAllStudent() 
{
List<GuideLinesEntity> students = new ArrayList<GuideLinesEntity>();
studentRepository.findAll().forEach(student -> students.add(student));
return students;
}

public static GuideLinesEntity targetNew() {
	GuideLinesEntity e1 = new GuideLinesEntity();

	SubRegionEntity sub1 = new SubRegionEntity();
//	sub1.setId(1);
	sub1.setValue(55);
	SubRegionEntity sub2 = new SubRegionEntity();
//	sub2.setId(2);
	sub2.setValue(67);

	RegionalEntity r = new RegionalEntity();

//	r.setId(1);


	BaseEntity b1 = new BaseEntity();
//	b1.setId(1);
	b1.setValue(57);
	BaseEntity b2 = new BaseEntity();
//	b2.setId(2);
	b2.setValue(58);

//	e1.setId(1);
	
	b1.setGuideLinesEntityByBase(e1);
	b2.setGuideLinesEntityByBase(e1);
	e1.setBase(List.of(b1, b2));
	e1.setVersion(1);
	sub1.setRegionalEntity(r);
	sub2.setRegionalEntity(r);
	r.setSubRegions(List.of(sub1, sub2));
	
	e1.setRegion(r);
	r.setGuideLinesEntity(e1);
	
	return e1;

}



public static GuideLinesEntity target() {
	GuideLinesEntity e1 = new GuideLinesEntity();

	SubRegionEntity sub1 = new SubRegionEntity();
	sub1.setId(1);
	sub1.setRegionId(1);
	sub1.setValue(89);
	SubRegionEntity sub2 = new SubRegionEntity();
	sub2.setId(3);
	sub2.setRegionId(1);
	sub2.setValue(88);

	RegionalEntity r = new RegionalEntity();
	r.setId(1);
	r.setPglId(1);
	r.setSubRegions(List.of(sub1, sub2));

	BaseEntity b1 = new BaseEntity();
	b1.setId(1);
	b1.setPglId(1);
	b1.setValue(67);
	BaseEntity b2 = new BaseEntity();
	b2.setId(3);
	b2.setPglId(1);
	b2.setValue(68);

	e1.setId(1);
	e1.setBase(List.of(b1, b2));
	e1.setVersion(1);
	e1.setRegion(r);
	return e1;

}


////getting a specific record
//public Student getStudentById(int id) 
//{
//return studentRepository.findById(id).get();
//}
public void saveOrUpdate() 
{
studentRepository.save(targetNew());
}

public void update() 
{
	 GuideLinesEntity entitySource = studentRepository.findById(1).get();
	 
//	 GuideLinesEntity entitySource = source();
		GuideLinesEntity entitytarget = target();

		entitySource.setVersion(entitySource.getVersion() + 1);
		if (!entitytarget.getBase().isEmpty()) {
			List<BaseEntity> baseList = entitytarget.getBase().stream().map(obj -> {
				BaseEntity base = null;
				if (obj.getId() != null && obj.getId() != 3) {
					entitySource.getBase().stream().forEach(obj1 -> System.out.println(obj1.getId()));
					base = entitySource.getBase().stream().filter(objT -> (objT.getId() == obj.getId())).findFirst()
							.get();
					entitySource.getBase().remove(base);
				} else {
					base = new BaseEntity();
				}
				base.setPglId(obj.getPglId());
				base.setValue(obj.getValue());
				return obj;
			}

			).collect(Collectors.toList());
			entitySource.getBase().addAll(baseList);
			//entitySource.setBase();
		}
//		List<SubRegionEntity> subRegions = subRegionRepository.findAllById(entitySource.getRegion().getId());
		if (!entitySource.getRegion().getSubRegions().isEmpty()) {
			
			List<SubRegionEntity> subList = entitytarget.getRegion().getSubRegions().stream().map(obj -> {
				SubRegionEntity sub = null;
				if (obj.getId() != null && obj.getId() != 3) {
					sub = entitySource.getRegion().getSubRegions().stream().filter(objT -> (objT.getId() == obj.getId())).findFirst()
							.get();
					entitySource.getRegion().getSubRegions().remove(sub);
				} else {
					sub = new SubRegionEntity();
				}
				sub.setRegionId(obj.getRegionId());
				sub.setValue(obj.getValue());
				return obj;
			}

			).collect(Collectors.toList());
			RegionalEntity re = entitySource.getRegion();
			re.setSubRegions(subList);
			re.getSubRegions().addAll(subList);
			entitySource.setRegion(re);
		}
studentRepository.save(entitySource);
}
////deleting a specific record
//public void delete(int id) 
//{
//studentRepository.deleteById(id);
//}
}