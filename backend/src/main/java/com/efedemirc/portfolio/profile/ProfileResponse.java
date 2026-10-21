package com.efedemirc.portfolio.profile;

/**
 * What the API returns. Kept separate from the entity so the database
 * shape can change without breaking the frontend contract.
 */
public record ProfileResponse(
        String fullName,
        String headline,
        String summary,
        String location,
        String email,
        String githubUrl,
        String linkedinUrl
) {
    static ProfileResponse from(Profile profile) {
        return new ProfileResponse(
                profile.getFullName(),
                profile.getHeadline(),
                profile.getSummary(),
                profile.getLocation(),
                profile.getEmail(),
                profile.getGithubUrl(),
                profile.getLinkedinUrl()
        );
    }
}
