package com.MainApp.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MainApp.Entity.Skills;
import com.MainApp.Repository.SkillsRepository;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository skillsRepo;

    // ── Icon map — keys must match SKILL_OPTIONS names in SkillsAdmin.jsx ─────
    private final Map<String, String> iconMap = Map.ofEntries(
        // Frontend
        Map.entry("React",            "FaReact"),
        Map.entry("JavaScript",       "SiJavascript"),
        Map.entry("HTML5",            "SiHtml5"),
        Map.entry("CSS3",             "FaCss3Alt"),
        Map.entry("TypeScript",       "SiTypescript"),
        Map.entry("Tailwind CSS",     "SiTailwindcss"),
        Map.entry("Next.js",          "SiNextdotjs"),
        Map.entry("Vue.js",           "SiVuedotjs"),
        Map.entry("Angular",          "SiAngular"),
        Map.entry("Svelte",           "SiSvelte"),
        Map.entry("Redux",            "SiRedux"),
        Map.entry("Webpack",          "SiWebpack"),
        Map.entry("Vite",             "SiVite"),
        Map.entry("Bootstrap",        "SiBootstrap"),
        // Backend
        Map.entry("Spring Boot",      "SiSpringboot"),
        Map.entry("Node.js",          "FaNodeJs"),
        Map.entry("Express",          "SiExpress"),
        Map.entry("Django",           "SiDjango"),
        Map.entry("FastAPI",          "SiFastapi"),
        Map.entry("Flask",            "SiFlask"),
        Map.entry("Laravel",          "SiLaravel"),
        Map.entry("GraphQL",          "SiGraphql"),
        Map.entry(".NET",             "SiDotnet"),
        // Database
        Map.entry("MongoDB",          "SiMongodb"),
        Map.entry("MySQL",            "SiMysql"),
        Map.entry("PostgreSQL",       "SiPostgresql"),
        Map.entry("Redis",            "SiRedis"),
        Map.entry("Firebase",         "SiFirebase"),
        Map.entry("SQLite",           "SiSqlite"),
        Map.entry("Supabase",         "SiSupabase"),
        Map.entry("Prisma",           "SiPrisma"),
        // Tools
        Map.entry("Git",              "FaGitAlt"),
        Map.entry("GitHub",           "FaGithub"),
        Map.entry("VS Code",          "VscVscode"),
        Map.entry("Docker",           "FaDocker"),
        Map.entry("Kubernetes",       "SiKubernetes"),
        Map.entry("Postman",          "SiPostman"),
        Map.entry("Figma",            "FaFigma"),
        Map.entry("Jira",             "SiJira"),
        Map.entry("Linux",            "FaLinux")
    );

    // Get all skills (Public)
    public List<Skills> getAllSkills() {
        return skillsRepo.findAll();
    }

    // Add new skill (Admin)
    public Skills addSkill(Skills skill) {
        String icon = iconMap.getOrDefault(skill.getName(), "FaReact");
        skill.setIcon(icon);
        return skillsRepo.save(skill);
    }

    // Delete skill (Admin)
    public void deleteSkill(String id) {
        skillsRepo.deleteById(id);
    }

    // Update skill (Admin)
    public Skills updateSkill(String id, Skills updatedSkill) {
        Optional<Skills> optional = skillsRepo.findById(id);
        if (optional.isPresent()) {
            Skills existing = optional.get();
            existing.setGroup(updatedSkill.getGroup());
            existing.setName(updatedSkill.getName());
            existing.setIcon(iconMap.getOrDefault(updatedSkill.getName(), "FaReact"));
            return skillsRepo.save(existing);
        } else {
            throw new RuntimeException("Skill not found with id: " + id);
        }
    }
}