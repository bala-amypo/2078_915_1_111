@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;
    private final StudentProfileRepository studentRepo;

    public HabitProfileServiceImpl(HabitProfileRepository repo, StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    public HabitProfile create(Long studentId, HabitProfileDto dto) {
        if (dto.getCleanlinessLevel() < 1 || dto.getCleanlinessLevel() > 5)
            throw new IllegalArgumentException("range 1-5");

        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile h = new HabitProfile();
        h.setStudent(student);
        h.setCleanlinessLevel(dto.getCleanlinessLevel());

        return repo.save(h);
    }
}
