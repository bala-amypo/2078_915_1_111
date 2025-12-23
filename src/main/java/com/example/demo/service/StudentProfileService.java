public interface StudentProfileService {

    StudentProfile create(StudentProfileDto dto, Long userId);

    StudentProfile update(Long id, StudentProfileDto dto);

    StudentProfile get(Long id);

    List<StudentProfile> getAll();   // 👈 REQUIRED
}
