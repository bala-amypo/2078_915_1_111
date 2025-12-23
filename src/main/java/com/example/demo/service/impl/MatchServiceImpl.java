@Service
public class MatchServiceImpl implements MatchService {

    private final MatchResultRepository repo;
    private final StudentProfileRepository studentRepo;

    public MatchServiceImpl(MatchResultRepository repo, StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    public MatchResult compute(Long a, Long b) {
        StudentProfile s1 = studentRepo.findById(a)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        StudentProfile s2 = studentRepo.findById(b)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        MatchResult r = new MatchResult();
        r.setStudentA(s1);
        r.setStudentB(s2);
        r.setScore(75.0);

        return repo.save(r);
    }

    public List<MatchResult> getForStudent(Long id) {
        return repo.findByStudentAIdOrStudentBIdOrderByScoreDesc(id, id);
    }
}
