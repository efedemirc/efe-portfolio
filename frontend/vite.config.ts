import react from '@vitejs/plugin-react'
import { defineConfig } from 'vite'

// In development the Vite server forwards /api calls to Spring Boot,
// so the browser only ever talks to one origin and no CORS setup is needed.
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': 'http://localhost:8080',
    },
  },
})
