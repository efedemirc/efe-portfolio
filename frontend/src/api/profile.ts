export interface Profile {
  fullName: string
  headline: string
  summary: string
  location: string | null
  email: string | null
  githubUrl: string | null
  linkedinUrl: string | null
}

export async function fetchProfile(signal?: AbortSignal): Promise<Profile> {
  const response = await fetch('/api/profile', { signal })
  if (!response.ok) {
    throw new Error(`Profile request failed with status ${response.status}`)
  }
  return (await response.json()) as Profile
}
