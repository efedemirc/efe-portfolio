import { useEffect, useState } from 'react'
import { fetchProfile, type Profile } from './api/profile'

type State =
  | { status: 'loading' }
  | { status: 'error' }
  | { status: 'ready'; profile: Profile }

export default function App() {
  const [state, setState] = useState<State>({ status: 'loading' })

  useEffect(() => {
    const controller = new AbortController()
    fetchProfile(controller.signal)
      .then((profile) => setState({ status: 'ready', profile }))
      .catch((error: unknown) => {
        if (!controller.signal.aborted) {
          console.error(error)
          setState({ status: 'error' })
        }
      })
    return () => controller.abort()
  }, [])

  if (state.status === 'loading') {
    return <main className="page centered">Loading…</main>
  }

  if (state.status === 'error') {
    return (
      <main className="page centered">
        <p>The site could not reach its API. Please try again in a moment.</p>
      </main>
    )
  }

  const { profile } = state

  return (
    <main className="page">
      <header className="hero">
        <h1>{profile.fullName}</h1>
        <p className="headline">{profile.headline}</p>
        {profile.location && <p className="muted">{profile.location}</p>}
      </header>

      <section>
        <h2>About</h2>
        <p>{profile.summary}</p>
      </section>

      <nav className="links" aria-label="Contact and profiles">
        {profile.email && <a href={`mailto:${profile.email}`}>Email</a>}
        {profile.githubUrl && (
          <a href={profile.githubUrl} target="_blank" rel="noreferrer">
            GitHub
          </a>
        )}
        {profile.linkedinUrl && (
          <a href={profile.linkedinUrl} target="_blank" rel="noreferrer">
            LinkedIn
          </a>
        )}
      </nav>
    </main>
  )
}
